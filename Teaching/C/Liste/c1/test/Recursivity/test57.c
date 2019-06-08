#include <stdio.h>
int jeu[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
int score(int position[3][3]) {
	int i = 0, resultat = 0;
	while ((i < 3) && (resultat == 0)) {
		if ((position[i][0] != 0) && (position[i][1] == position[i][0]) &&
				(position[i][2] == position[i][0]))
			resultat = position[i][0];
		else if ((position[0][i] != 0) && (position[1][i] == position[0][i]) &&
						 (position[2][i] == position[0][i]))
			resultat = position[0][i];
		i = i + 1;
	}
	if (resultat == 0) {
		if ((position[0][0] != 0) && (position[1][1] == position[0][0]) &&
				(position[2][2] == position[0][0]))
			resultat = position[0][0];
		else if ((position[0][2] != 0) && (position[1][1] == position[0][2]) &&
						 (position[2][0] == position[0][2]))
			resultat = position[0][2];
	}
	return resultat;
}

int minimax(int position[3][3], int joueur) {
	int resultat, i, j, resultat_coup, coups_possibles = 0;
	resultat = score(position);
	if (resultat == 0) {
		resultat = -joueur; /* pire cas */
		for (i = 0; i < 3; i = i + 1) {
			for (j = 0; j < 3; j = j + 1) {
				if (position[i][j] == 0) {
					position[i][j] = joueur;
					resultat_coup = minimax(position, -joueur);
					position[i][j] = 0;

					coups_possibles = 1;
					if (resultat_coup * joueur > resultat * joueur) {
						resultat = resultat_coup;
					}
				}
			}
		}
		if (coups_possibles == 0)
			resultat = 0;
	}
	return resultat;
}
void jouer(int position[3][3], int joueur) {
	int resultat, i, j, resultat_coup, i_mieux, j_mieux;
	resultat = -2 * joueur;
	for (i = 0; i < 3; i = i + 1) {
		for (j = 0; j < 3; j = j + 1) {
			if (position[i][j] == 0) {
				position[i][j] = joueur;
				resultat_coup = minimax(position, -joueur);
				position[i][j] = 0;

				if (resultat_coup * joueur > resultat * joueur) {
					resultat = resultat_coup;
					i_mieux = i;
					j_mieux = j;
				}
			}
		}
	}
	position[i_mieux][j_mieux] = joueur;
	printf("Le joueur %d joue en %d,%d.", joueur, i_mieux, j_mieux);
}

int main() {
	int joueur = 1, nb_libre = 9, score_actuel = 0;
	while ((nb_libre > 0) && (score_actuel == 0)) {
		if (joueur == 1) { /* ordinateur */
			jouer(jeu, 1);
		} else {
			/* joueur humain */
			int i, j;
			printf("Entrez votre coup : ");
			scanf("%d", &i);
			scanf("%d", &j);
			jeu[i][j] = -1;
			/* très mauvais : aucun test d’erreur */
		}
		score_actuel = score(jeu);
		nb_libre = nb_libre - 1;
		joueur = -joueur;
	}
	if (score_actuel == 0)
		printf("Match nul !\n");
	else if (score_actuel == 1)
		printf("L’ordinateur a gagné !\n");
	else
		printf("Vous avez gagné (et triché).\n");
	return 0;
}
