package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/*
1. В пакете ad создайте StatisticAdvertisementManager, который будет предоставлять информацию из AdvertisementStorage в нужном нам виде.
Сделайте его синглтоном.
3. В классе StatisticAdvertisementManager создайте и проинициализируйте поле типа AdvertisementStorage.
4.  В StatisticAdvertisementManager создайте два(или один) метода (придумать самостоятельно), которые из хранилища
AdvertisementStorage достанут все необходимые данные - соответственно список активных и неактивных рекламных роликов.
Активным роликом считается тот, у которого есть минимум один доступный показ.
Неактивным роликом считается тот, у которого количество показов равно 0.
*/
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getActiveAdvertisements() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0)
                result.add(advertisement);
        }
        return result;
    }

    public List<Advertisement> getNonActiveAdvertisements() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() == 0)
                result.add(advertisement);
        }
        return result;
    }

}
