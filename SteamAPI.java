package steamget;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class SteamAPI {
  private static String unsafe_search(String game) throws IOException {
    Document doc = Jsoup.connect("http://store.steampowered.com/search/?term=" + game + "&category1=998").get();
    String[] prices = doc.select("div.col.search_price.responsive_secondrow").first().text().split("\\s");
    String price = prices[prices.length-1];
    if (price.indexOf('.')<0)
      price = "$0.00";
    return price;
    }
  public static String search(String game){
    try {
      return unsafe_search(game);
    } catch (IOException e) {
      return "not listed on steam";
    }
  }
  public static List (String game) throws IOException {
    Scanner reader = new Scanner(System.in);
    System.out.println("Give a game: ");
    String game = reader.next();
    //Document d=Jsoup.connect("http://store.steampowered.com/app/" + url + "/").cookie("mature_content", "1").cookie("birthtime","0").get();

    Document doc = Jsoup.connect("http://store.steampowered.com/search/?term=" + game + "&category1=998").get();
    //String[] prices = doc.select("div.col.search_price.responsive_secondrow").first().text().split("\\s");
    //String price = prices[prices.length-1];
    //if (price.indexOf('.')<0)
    //    price = "$0.00";
    List<String> results = doc.select("div.col.search_name.ellipsis").eachText();
    List<String> prices = doc.select("div.col.search_price.responsive_secondrow").eachText();
    for(int i = 0;i<prices.size();i++) {
      results.get(i).split("//s");
      prices.get(i).split("//s");

    }
    System.out.println(results);
    System.out.println(prices);








}
