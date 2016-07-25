package com.javarush.test.level27.lesson15.big01.ad;

/*
Метод должен:
2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду. (Следующее задание)
2.4. Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа одного рекламного ролика
в копейках. Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки
Используйте метод Collections.sort
(Будет тестироваться вместе со следующим заданием)
Пример для заказа [Water]:
First Video is displaying... 50, 277
где First Video - название рекламного ролика
где 50 - стоимость показа одного рекламного ролика в копейках
где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
Используйте методы из класса Advertisement.
2.6. Для каждого показанного рекламного ролика пересчитать его данные вызвав метод revalidate() у объекта класса Advertisement.
*/

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> videos = OptimalVideoList(powerLists(storage.list()));
        Comparator comparator = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;
                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        };
        Collections.sort(videos, comparator);
        for (Advertisement a : videos) {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", a.getName(), a.getAmountPerOneDisplaying(), a.getAmountPerOneDisplaying() * 1000 / a.getDuration()));
            a.revalidate();
        }
        if (videos.size() <= 0 || videos == null) {
            throw new NoVideoAvailableException();
        }
    }

    public List<Advertisement> OptimalVideoList(List<List<Advertisement>> list) {
        List<Advertisement> optimal = new ArrayList<>();
        Iterator A = list.iterator();
        while (A.hasNext()) {  // Перебор наборов видео
            List<Advertisement> checkList = (ArrayList<Advertisement>) A.next();
            int timeOfVideoSet = 0;
            boolean removeSet = false;
            for (Advertisement a : checkList) {      // Перебор= видео в наборе
                timeOfVideoSet += a.getDuration();
                if (a.getHits() <= 0) {
                    removeSet = true;
                }
            }
            if (timeOfVideoSet > timeSeconds) {
                removeSet = true;
            }
            if (removeSet) {
                A.remove();
            }
        }
        Comparator comparator = new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                long profit1 = 0, profit2 = 0;
                int durationOfVideoSet1 = 0, durationOfVideoSet2 = 0;
                for (Advertisement a : o1) {
                    profit1 += a.getAmountPerOneDisplaying();
                    durationOfVideoSet1 += a.getDuration();
                }
                for (Advertisement a : o2) {
                    profit2 += a.getAmountPerOneDisplaying();
                    durationOfVideoSet2 += a.getDuration();
                }
                if (profit1 != profit2)
                    return Long.compare(profit2, profit1);   // первичная по прибыли от показа (по убыванию)
                if (durationOfVideoSet1 != durationOfVideoSet2)
                    return Integer.compare(durationOfVideoSet2, durationOfVideoSet1);  // вторичная по длительности (по убыванию)
                else return Integer.compare(o1.size(), o2.size());  // по размеру списка (по возрастанию)
            }
        };
        Collections.sort(list, comparator);
        optimal = list.get(0);    // выбираем первый элемент(найболее подходящий)
        return optimal;
    }

    private <Advetisement> List<List<Advetisement>> powerLists(List<Advetisement> originalSet) {
        List<List<Advetisement>> lists = new ArrayList<List<Advetisement>>();
        if (originalSet.isEmpty()) {
            lists.add(new ArrayList<Advetisement>());
            return lists;
        }
        List<Advetisement> list = new ArrayList<Advetisement>(originalSet);
        Advetisement head = list.get(0);
        List<Advetisement> rest = new ArrayList<Advetisement>(list.subList(1, list.size()));
        for (List<Advetisement> aList : powerLists(rest)) {
            List<Advetisement> newList = new ArrayList<Advetisement>();
            newList.add(head);
            newList.addAll(aList);
            lists.add(newList);
            lists.add(aList);
        }
        return lists;
    }
}
