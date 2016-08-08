package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {

    private final static String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static final String referrer = "https://moikrug.ru";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            Document document;
            int pageCounter = 1;

            while (true) {
                document = getDocument(searchString, pageCounter++);
                if (document == null) break;

                Elements elements = document.getElementsByClass("job");
                if (elements.size() == 0) break;

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();

                    vacancy.setUrl(element.getElementsByClass("title").first().child(0).attr("abs:href"));
                    vacancy.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("class", "location").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "salary").text());
                    vacancy.setSiteName("https://moikrug.ru/");
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").first().child(0).text());

                    vacancies.add(vacancy);
                }
            }
        } catch (Exception e) {
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, page, searchString);
        //String url = URL_FORMAT;
        return Jsoup.connect(url).
                userAgent(userAgent).
                referrer(referrer).
                get();
    }
}