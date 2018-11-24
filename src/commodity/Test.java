package commodity;

public class Test {
	public static void show(Commodity[] c) {
		for (Commodity cc : c) {
			System.out.println("��Ʒ��������"+cc.getName());
			System.out.println("��Ʒ��������"+cc.getAmount());
			System.out.println("��Ʒ��ID��"+cc.getId());
			System.out.println("��Ʒ��״̬��"+cc.getState());
			System.out.println("��Ʒ�ļ۸���"+cc.getPrice());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}
	}
	public static void main(String[] args) {
		ICommodityDao icd = new CommodityDaoImpl();
		Commodity c1 = new Commodity("001", "����", 3, 10, "�ϼ�");
		Commodity c2 = new Commodity("002", "ѩ��", 3, 12, "�ϼ�");
		Commodity c3 = new Commodity("003", "����", 4, 5, "�ϼ�");
		Commodity c4 = new Commodity("004", "����", 5, 6, "�¼�");
		Commodity c5 = new Commodity("005", "�����", 3, 17, "�ϼ�");
		Commodity c6 = new Commodity("006", "����", 5, 6, "�ϼ�");
		Commodity c7 = new Commodity("007", "ơ��", 6, 98, "�ϼ�");
		Commodity c8 = new Commodity("008", "����", 8,5, "�ϼ�");
		icd.save(c1);
		icd.save(c2);
		icd.save(c3);
		icd.save(c4);
		icd.save(c5);
		icd.save(c6);
		icd.save(c7);
		icd.save(c8);
		show(icd.showAll());
		System.out.println("~~~~~~~������Ʒid��ʾ~~~~~~~~~~~");
		Commodity c = icd.showById("007");
		if (null != c) {
			System.out.println("��Ʒ��������"+c.getName());
			System.out.println("��Ʒ��������"+c.getAmount());
			System.out.println("��Ʒ��ID��"+c.getId());
			System.out.println("��Ʒ��״̬��"+c.getState());
			System.out.println("��Ʒ�ļ۸���"+c.getPrice());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		System.out.println("~~~~~~~~������Ʒ��������~~~~~~~~~~~~");
		Commodity[] a = icd.showByName("����");
		show(a);
		System.out.println("~~~~~~~�鿴�����¼���Ʒ~~~~~~~~~~~");
		Commodity[] b = icd.showByDel();
		show(b);
		Commodity[] aa = {c1,c2,c3,c4,c5,c6,c7,c8};
		System.out.println("~~~~~~��������Ʒ������������~~~~~~~");
		show(icd.sortByAmend(aa));
		System.out.println("~~~~~~���ݼ۸����������Ʒ~~~~~~~~~~~~");
		Commodity[] byPr = icd.showByprice(4, 6);
		show(byPr);
		System.out.println("~~~~~~~~~ɾ��~~~~~~~~~~~~``");
		Commodity q = icd.del("����", 1);
		System.out.println("��Ʒ��������"+q.getName());
		System.out.println("��Ʒ��������"+q.getAmount());
		System.out.println("��Ʒ��ID��"+q.getId());
		System.out.println("��Ʒ��״̬��"+q.getState());
		System.out.println("��Ʒ�ļ۸���"+q.getPrice());
		System.out.println("~~~~~~~������Ʒid�޸�~~~~~~~~~~");
		icd.amend("002");
		show(icd.showAll());
	}
}
