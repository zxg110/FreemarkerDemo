package com.for_future.codegenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于描述NetApi
 */
public class SaicNetApiModel extends GeneratorModel{
    //NetApi列表
    private List<SaicNetApiBean> saicNetApiBeanList = new ArrayList<SaicNetApiBean>();

    public void addNetApiBean(SaicNetApiBean saicNetApiBean) {
        saicNetApiBeanList.add(saicNetApiBean);
    }

    public List<SaicNetApiBean> getSaicNetApiBeanList() {
        return saicNetApiBeanList;
    }

    public void setSaicNetApiBeanList(List<SaicNetApiBean> saicNetApiBeanList) {
        this.saicNetApiBeanList = saicNetApiBeanList;
    }
}
