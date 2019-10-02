package Lexer;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringLexer {
	
  public static enum Type {

    NB("-?[0-9]+"), OP("[*|/|+|-]"), SPACE("[ \t\f\r\n]+");

    public final String pattern;

    private Type(String pattern) {
      this.pattern = pattern;
    }
  }

  public static class Element {
    public Type type;
    public String data;

    public Element(Type type, String data) {
      this.type = type;
      this.data = data;
    }

    @Override
    public String toString() {
      return String.format("(%s %s)", type.name(), data);
    }
  }

  public static ArrayList<Element> lex(String input) {

    ArrayList<Element> elements = new ArrayList<Element>();

    StringBuffer elementPatternsBuffer = new StringBuffer();
    for (Type elementType : Type.values())
      elementPatternsBuffer.append(String.format("|(?<%s>%s)", elementType.name(), elementType.pattern));
    Pattern elementPatterns = Pattern.compile(new String(elementPatternsBuffer.substring(1)));

    Matcher matcher = elementPatterns.matcher(input);
    while (matcher.find()) {
      if (matcher.group(Type.NB.name()) != null) {
        elements.add(new Element(Type.NB, matcher.group(Type.NB.name())));
        continue;
      } else if (matcher.group(Type.OP.name()) != null) {
        elements.add(new Element(Type.OP, matcher.group(Type.OP.name())));
        continue;
      } else if(matcher.){
      } else if (matcher.group(Type.SPACE.name()) != null)
        continue;
    }

    return elements;
  }

  public static void main(String[] args) {
    String input = "11 + 22 - 33";

    ArrayList<Element> elements = lex(input);
    for (Element element : elements)
      System.out.println(element);
  }
}

