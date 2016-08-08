package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static final String referrer = "https://hh.ru";

    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int pageNumber = 0;
            Document doc;
            while (true) {
                doc = getDocument(searchString, pageNumber++);
                if (doc == null) break; // когда страницы кончаться, то выйдем из цикла

                Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]"); // добавляем все элементы в elements, это ArrrayList
                if (elements.size() == 0) break;

                for (Element element : elements) {
                    // title
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();

                    // salary
                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }

                    // city
                    String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();

                    // company
                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();

                    // site
                    String siteName = referrer;

                    // url
                    String url = titleElement.attr("href");

                    // add vacancy to the list
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);

                }
            }
        } catch (Exception e) {

        }
        System.out.println("Vacancies from " + referrer + " are ready!");
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {

        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url)
                .userAgent(userAgent)
                .referrer(referrer)
                .get();
        return document;
    }
}