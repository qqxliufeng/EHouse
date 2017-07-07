package com.android.yt.ehouse.app.ui.fragment.shoppingcar;

import com.android.yt.ehouse.app.data.bean.GoodsItemBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by feng on 2017/7/6.
 */

public class ShoppingCarManager {

    private ShoppingCarManager() {
        addTestItem();
    }

    private static ShoppingCarManager shoppingCarManager;

    public static ShoppingCarManager getInstance() {
        if (shoppingCarManager == null) {
            synchronized (ShoppingCarManager.class) {
                if (shoppingCarManager == null) {
                    shoppingCarManager = new ShoppingCarManager();
                }
            }
        }
        return shoppingCarManager;
    }

    private ArrayList<GoodsItemBean> goodsList = new ArrayList<>();
    private ArrayList<GoodsItemBean> selectedList = new ArrayList<>();
    private Map<Integer, ArrayList<GoodsItemBean>> listMap = new HashMap<>();

    public void addTestItem() {
        for (int i = 0; i < 20; i++) {
            GoodsItemBean goodsItemBean = new GoodsItemBean();
            switch (i) {
                case 0:
                case 1:
                    goodsItemBean.setFlag(1);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    goodsItemBean.setFlag(2);
                    break;
                case 8:
                case 9:
                    goodsItemBean.setFlag(3);
                    break;
                case 10:
                    goodsItemBean.setFlag(4);
                    break;
                case 11:
                case 12:
                case 13:
                    goodsItemBean.setFlag(5);
                    break;
                default:
                    goodsItemBean.setFlag(6);
            }
            goodsItemBean.setTitle("item  " + i);
            goodsItemBean.setAddTime(System.currentTimeMillis());
            goodsList.add(goodsItemBean);
        }
        sortListAndSetSection();
    }

    public void setGoodsList(ArrayList<GoodsItemBean> goodsItemBeanArrayList) {
        if (goodsItemBeanArrayList == null) {
            throw new IllegalStateException("shopping car list must be not null");
        }
        this.goodsList.addAll(goodsItemBeanArrayList);
        sortListAndSetSection();
    }

    /**
     * 得到商品集合
     *
     * @return 商品集合
     */
    public ArrayList<GoodsItemBean> getGoodsList() {
        return goodsList;
    }


    /**=======================================manager section======================================================**/

    /**
     * 根据商品的Flag 对商品进行分组
     *
     * @param goodsItemBean
     */
    private void setSectionByFlag(GoodsItemBean goodsItemBean) {
        if (listMap.containsKey(goodsItemBean.getFlag())) {
            ArrayList<GoodsItemBean> goodsItemBeans = listMap.get(goodsItemBean.getFlag());
            goodsItemBeans.add(goodsItemBean);
        } else {
            ArrayList<GoodsItemBean> tempList = new ArrayList<>();
            tempList.add(goodsItemBean);
            listMap.put(goodsItemBean.getFlag(), tempList);
        }
    }

    /**
     * 根据商品的Flag 查找出商品所在的组集合
     *
     * @param flag
     * @return
     */
    private ArrayList<GoodsItemBean> getSectionListByFlag(int flag) {
        if (listMap.containsKey(flag))
            return listMap.get(flag);
        return null;
    }


    /**
     * 将商品进行分组
     */
    private void sortListAndSetSection() {
        for (GoodsItemBean goodsItemBean : goodsList) {
            setSectionByFlag(goodsItemBean);
        }
        setFirstItemByFlag();
    }

    /**
     * 根据添加的时间进行排序
     *
     * @param list 要进行排序的集合
     */
    private void sortListByAddTime(ArrayList<GoodsItemBean> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new Comparator<GoodsItemBean>() {
                @Override
                public int compare(GoodsItemBean o1, GoodsItemBean o2) {
                    return o2.getAddTime().compareTo(o1.getAddTime());
                }
            });
        }
    }


    /**=======================================manager item======================================================**/

    /**
     * 添加新的商品
     *
     * @param goodsItemBean 待添加的商品
     */
    public void addItem(GoodsItemBean goodsItemBean) {
        if (goodsItemBean != null) {
            goodsList.add(goodsItemBean);
            setSectionByFlag(goodsItemBean);
            setPreviousItemIndexByFlag(goodsItemBean.getFlag());
        }
    }

    /**
     * 移除商品，从总的集合中移除，从分组集合中移除
     *
     * @param goodsItemBean 待移除的商品
     */
    public void removeItem(GoodsItemBean goodsItemBean) {
        if (goodsItemBean != null && goodsList.contains(goodsItemBean)) {
            goodsList.remove(goodsItemBean);
            ArrayList<GoodsItemBean> sectionList = listMap.get(goodsItemBean.getFlag());
            sectionList.remove(goodsItemBean);
            setNextItemIndexByFlag(sectionList);
        }
    }

    /**
     * 根据商品分类Flag得到 某一组商品的 Flag为1 的商品
     *
     * @param flag
     * @return
     */
    public GoodsItemBean getFirstItemByFlag(int flag) {
        ArrayList<GoodsItemBean> sectionList = listMap.get(flag);
        GoodsItemBean firstItem = null;
        int size = sectionList.size();
        //循环找出第一个Item
        for (int i = 0; i < size; i++) {
            if (sectionList.get(i).getIndex() == 1) {
                firstItem = sectionList.get(i);
                //找到之后直接跳出循环
                break;
            }
        }
        return firstItem;
    }

    /**
     * 把分好组的集合的第一个元素的Index设置为1 其余的设置为2
     */
    private void setFirstItemByFlag() {
        Set<Map.Entry<Integer, ArrayList<GoodsItemBean>>> entries = listMap.entrySet();
        for (Map.Entry<Integer, ArrayList<GoodsItemBean>> entry : entries) {
            ArrayList<GoodsItemBean> value = entry.getValue();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                GoodsItemBean goodsItemBean = value.get(i);
                if (i == 0) {
                    goodsItemBean.setIndex(1);
                } else {
                    goodsItemBean.setIndex(2);
                }
            }
        }
    }

    /**
     * 对某一分组进行设置下一个商品的Flag 为 1
     *
     * @param sectionList 要设置的商品分组
     * @return 返回已经设置Flag为1 的商品
     */
    private void setNextItemIndexByFlag(ArrayList<GoodsItemBean> sectionList) {
        for (GoodsItemBean item : sectionList) {
            if (item.getIndex() == 2) {
                item.setSectionSelected(item.isItemSelected());
                item.setIndex(1);
                break;
            }
        }
    }

    /**
     * 把某一个集合的第一个Item的Index设置为1
     *
     * @param flag
     */
    private void setPreviousItemIndexByFlag(int flag) {
        ArrayList<GoodsItemBean> sectionList = listMap.get(flag);
        sectionList.get(0).setIndex(1);
        for (int i = 1; i < sectionList.size(); i++) {
            sectionList.get(i).setIndex(2);
        }
    }


    /**=======================================manager other======================================================**/

    /**
     * 根据选中的商品 进行判定是否要选中一整个分组
     *
     * @param goodsItemBean 选中的商品
     */
    public void setItemSelectedByGoodItemFlag(GoodsItemBean goodsItemBean) {
        GoodsItemBean firstItem = getFirstItemByFlag(goodsItemBean.getFlag());
        goodsItemBean.setItemSelected(!goodsItemBean.isItemSelected());
        goodsItemBean.setSectionSelected(goodsItemBean.isItemSelected());
        ArrayList<GoodsItemBean> sectionList = getSectionListByFlag(goodsItemBean.getFlag());
        if (sectionList != null) {
            int size = sectionList.size();
            for (int i = 0; i < size; i++) {
                GoodsItemBean item = sectionList.get(i);
                if (firstItem != null) {
                    if (!item.isItemSelected()) {
                        firstItem.setSectionSelected(false);
                        break;
                    } else {
                        firstItem.setSectionSelected(true);
                    }
                }
            }
        }
    }

    /**
     * 根据选中的商品把整个组选中
     *
     * @param goodsItemBean
     */
    public void setSectionSelectedByGoodsItemFlag(GoodsItemBean goodsItemBean) {
        GoodsItemBean firstItem = getFirstItemByFlag(goodsItemBean.getFlag());
        ArrayList<GoodsItemBean> sectionList = getSectionListByFlag(goodsItemBean.getFlag());
        if (firstItem != null && sectionList != null) {
            firstItem.setSectionSelected(!firstItem.isSectionSelected());
            for (GoodsItemBean item : sectionList) {
                item.setItemSelected(firstItem.isSectionSelected());
            }
        }
    }

    /**
     * 全部是否选中
     *
     * @param isChecked true 全部选中 otherwise 全部取消选中
     */
    public void setAllSelected(boolean isChecked) {
        for (GoodsItemBean item : goodsList) {
            if (item.getIndex() == 1) {
                item.setSectionSelected(isChecked);
            }
            item.setItemSelected(isChecked);
        }
    }

    /**
     * 获取所有的选中的商品
     *
     * @return 所有的商品
     */
    public ArrayList<GoodsItemBean> getSelectedList() {
        selectedList.clear();
        for (GoodsItemBean item : goodsList) {
            if (item.isItemSelected()) {
                selectedList.add(item);
            }
        }
        return selectedList;
    }
}
