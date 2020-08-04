import java.util.ArrayList;
import java.util.Scanner;

public class WebCrawler {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url); // Crawl from starting URL
        input.close();
    }

    public static void crawler(String startingURL) {

        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfCrawledURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURL);

        // Check if we've already crawled the URL
        while (!listOfPendingURLs.isEmpty() && listOfCrawledURLs.size() <=100) {
            String urlString = listOfPendingURLs.remove(0);
            if(!listOfCrawledURLs.contains(urlString)) {
                listOfCrawledURLs.add(urlString);
                System.out.println("Crawl: " + urlString);

                for (String s : getSubURLs(urlString)) {
                    if (!listOfCrawledURLs.contains(s)) {
                        listOfPendingURLs.add(s);
                    }
                }
            }
        }
        
    } 

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        try {

            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;

            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current); // Checks for occurrence of http
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current); // End of url
                    if (endIndex > 0) {
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    } else {
                        current = -1;
                    }
                }
            }
            

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return list;

    }
}
