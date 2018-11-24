package commodity;

public class Test {
	public static void show(Commodity[] c) {
		for (Commodity cc : c) {
			System.out.println("商品的名字是"+cc.getName());
			System.out.println("商品的数量是"+cc.getAmount());
			System.out.println("商品的ID是"+cc.getId());
			System.out.println("商品的状态是"+cc.getState());
			System.out.println("商品的价格是"+cc.getPrice());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}
	}
	public static void main(String[] args) {
		ICommodityDao icd = new CommodityDaoImpl();
		Commodity c1 = new Commodity("001", "可乐", 3, 10, "上架");
		Commodity c2 = new Commodity("002", "雪碧", 3, 12, "上架");
		Commodity c3 = new Commodity("003", "脉动", 4, 5, "上架");
		Commodity c4 = new Commodity("004", "咖啡", 5, 6, "下架");
		Commodity c5 = new Commodity("005", "美年达", 3, 17, "上架");
		Commodity c6 = new Commodity("006", "可乐", 5, 6, "上架");
		Commodity c7 = new Commodity("007", "啤酒", 6, 98, "上架");
		Commodity c8 = new Commodity("008", "花生", 8,5, "上架");
		icd.save(c1);
		icd.save(c2);
		icd.save(c3);
		icd.save(c4);
		icd.save(c5);
		icd.save(c6);
		icd.save(c7);
		icd.save(c8);
		show(icd.showAll());
		System.out.println("~~~~~~~根据商品id显示~~~~~~~~~~~");
		Commodity c = icd.showById("007");
		if (null != c) {
			System.out.println("商品的名字是"+c.getName());
			System.out.println("商品的数量是"+c.getAmount());
			System.out.println("商品的ID是"+c.getId());
			System.out.println("商品的状态是"+c.getState());
			System.out.println("商品的价格是"+c.getPrice());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		System.out.println("~~~~~~~~根据商品名字现在~~~~~~~~~~~~");
		Commodity[] a = icd.showByName("可乐");
		show(a);
		System.out.println("~~~~~~~查看所有下架商品~~~~~~~~~~~");
		Commodity[] b = icd.showByDel();
		show(b);
		Commodity[] aa = {c1,c2,c3,c4,c5,c6,c7,c8};
		System.out.println("~~~~~~给所有商品根据数量排序~~~~~~~");
		show(icd.sortByAmend(aa));
		System.out.println("~~~~~~根据价格区间查找商品~~~~~~~~~~~~");
		Commodity[] byPr = icd.showByprice(4, 6);
		show(byPr);
		System.out.println("~~~~~~~~~删除~~~~~~~~~~~~``");
		Commodity q = icd.del("花生", 1);
		System.out.println("商品的名字是"+q.getName());
		System.out.println("商品的数量是"+q.getAmount());
		System.out.println("商品的ID是"+q.getId());
		System.out.println("商品的状态是"+q.getState());
		System.out.println("商品的价格是"+q.getPrice());
		System.out.println("~~~~~~~根据商品id修改~~~~~~~~~~");
		icd.amend("002");
		show(icd.showAll());
	}
}
