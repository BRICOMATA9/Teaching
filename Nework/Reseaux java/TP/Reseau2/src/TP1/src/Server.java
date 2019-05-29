import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Server {

	private static String clientChannel = "clientChannel";
	private static String serverChannel = "serverChannel";
	private static String channelType = "channelType";

	public static void main(String[] args) throws IOException {

		//Obtenir le numero de port de l'utilisateur
		int port = Integer.parseInt(args[0]);
		//Obtenir l'address local du hote 127.0.0.1
		String localhost = "localhost";
		//créer un nouveau serversocketchannel. Le canal est non liée.
		ServerSocketChannel channel = ServerSocketChannel.open();
		//lier le canal à une adresse. Le canal commence à écouter les connexions entrantes.
		channel.bind(new InetSocketAddress(localhost, port));
		//marquer le serversocketchannel comme non blocante
		channel.configureBlocking(false);
		// Créer un sélecteur qui sera utilisé pour le multiplexage
		// enregistrer le canal de SocketServer pour tous les SocketChannels qui sont créés
		Selector selector = Selector.open();
		// Enregistre le serversocketchannel avec le sélecteur.
		// L'options OP_ACCEPT marques Une clé de sélection lorsque le canal accepte une nouvelle connexion.
		// Quand le Serveur de socket accepte une connexion sur cette clé, elle est ajouté à la liste des clés du sélecteur.
		// Lorsqu'on lui a demandé les clés sélectionnées, cette clé est retourné et donc on
    // Sait qu'une nouvelle connexion a été acceptée.
		SelectionKey socketServerSelectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);
		//propriété située dans la clé qui identifie le canal
		Map<String, String> properties = new HashMap<String, String>();
		properties.put(channelType, serverChannel);
		socketServerSelectionKey.attach(properties);
		// Attendre les clés sélectionnées
		while (true) {
		// La méthode de sélection est une méthode de blocage qui retourne quand au moins un 
		// des canaux enregistrés est sélectionné. Dans cet exemple, lorsque la socket accepte une 
		// nouvelle connexion, cette méthode sera de retour. Une fois socketclient est ajouté 
		// à la liste des canaux enregistrés, cette méthode serait également revenir lorsque 
		// l'un des clients a données à lire ou écrite. 
		// Il est également possible d'effectuer une sélectionn non bloquante en utilisant 
		// la fonction selectNow(). 
		// Nous pouvons également spécifier la durée maximale pendant laquelle une fonction de sélection 
		// peut être bloquée en utilisant la fonction select(long timeout).
			if (selector.select() == 0) continue;
		// La méthode de sélection renvoie une liste de clés sélectionnées
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			while (iterator.hasNext()) {

				SelectionKey key = iterator.next();
				// La clé de sélection pourrait soit par informant SocketServer
				// Qu'une nouvelle connexion a été établie, ou
				// Un socket client qui est prêt pour la lecture / écriture est dispoonible
				// Nous utilisons les propriétés objets attachés à la chaîne à trouvé
				// dans le type de canal.
				if (((Map<?, ?>) key.attachment()).get(channelType).equals(serverChannel)) {

					ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
					SocketChannel clientSocketChannel = serverSocketChannel.accept();
					if (clientSocketChannel != null) {

						clientSocketChannel.configureBlocking(false);
						SelectionKey clientKey = clientSocketChannel.register(selector, SelectionKey.OP_READ,SelectionKey.OP_WRITE);
						Map<String, String> clientproperties = new HashMap<String, String>();
						clientproperties.put(channelType, clientChannel);
						clientKey.attach(clientproperties);
						CharBuffer buffer = CharBuffer.wrap("Hello client");
						while (buffer.hasRemaining())
							clientSocketChannel.write(Charset.defaultCharset().encode(buffer));
						buffer.clear();
					}

				} else {

					ByteBuffer buffer = ByteBuffer.allocate(20);
					SocketChannel clientChannel = (SocketChannel) key.channel();
					int bytesRead = 0;
					if (key.isReadable()) {

						if ((bytesRead = clientChannel.read(buffer)) > 0) {
							buffer.flip();
							System.out.println(Charset.defaultCharset().decode(buffer));
							buffer.clear();
						}
						if (bytesRead < 0) {
							clientChannel.close();
						}
					}

				}
				iterator.remove();
			}
		}

	}
}
