package commodity;

import java.util.Scanner;

public class CommodityDaoImpl implements ICommodityDao{
	Commodity[] comm;
	int index = 0;
	
	
	public CommodityDaoImpl() {
		comm = new Commodity[10];
	}
	
	public CommodityDaoImpl(int n) {
		comm = new Commodity[n];
	}
	@Override
	public boolean save(Commodity c) {
		if(index < comm.length) {
			comm[index] = c;
			index++;
			return true;
		}
		return false;
	}

	@Override
	public Commodity del(String name, int n) {
		
		for(int i = 0 ; i < index; i++) {
			if(comm[i].getName().equals(name)) {
				comm[i].setAmount(comm[i].getAmount()-n);
				index--;
				return comm[i];
			}
		}
		return null;
		
	}

	@Override
	public boolean amend(String id) {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < index; i++) {
			if (comm[i].getId().equals(id)) {
				System.out.println("��������Ҫ�޸ĵ�����ѡ��");
				System.out.println("1.����");
				System.out.println("2.��Ʒ����");
				System.out.println("3.��Ʒ����");
				System.out.println("4.��Ʒ״̬");
				int a = s.nextInt();
				if (1 == a) {
					System.out.println("������Ҫ�޸ĵ�����");
					comm[i].setName(s.nextLine());
					System.out.println("�޸ĳɹ�");
				} else if (2 == a) {
					System.out.println("��������Ҫ�޸ĵĵ���");
					comm[i].setPrice(s.nextDouble());
					System.out.println("�޸ĳɹ�");
				} else if (3 == a) {
					System.out.println("��������Ҫ�޸ĵ�����");
					comm[i].setAmount(s.nextInt());
					System.out.println("�޸ĳɹ�");
				} else if (4 == a) {
					System.out.println("��������Ҫ�޸ĵ���Ʒ״̬");
					comm[i].setState(s.nextLine());
					System.out.println("�޸ĳɹ�");
				}
				return true;
				
			}
		}
		
		return false;
	}

	@Override
	public Commodity[] showAll() {
		Commodity[] cd = new Commodity[index];
		System.arraycopy(comm, 0, cd, 0, index);
		return cd;
	}

	@Override
	public Commodity showById(String id) {
		
		for (int i = 0; i < index; i++) {
			if (comm[i].getId().equals(id)) {
				return comm[i];
			}
		}
		return null;
		
	}

	@Override
	public Commodity[] showByName(String name) {
		int count = 0;
		for (int i = 0; i < index; i++) {
			if (comm[i].getName().equals(name)) {
				count++;
			}
		}
		if (0 == count) {
			return null;
		}
		Commodity[] c = new Commodity[count];
		for (int i = 0; i < index; i++) {
			if (comm[i].getName().equals(name)) {
				c[--count] = comm[i];
			}
		}
		
		return c;
	}

	@Override
	public Commodity[] showByprice(int a, int b) {
		int count = 0;
		for (int i = 0; i < index; i++) {
			if (comm[i].getPrice() >= a && comm[i].getPrice() <= b) {
				count++;
			}
		}
		if (0 == count) {
			return null;
		}
		Commodity[] c = new Commodity[count];
		for (int i = 0; i < index; i++) {
			if (comm[i].getPrice() >= a && comm[i].getPrice() <= b) {
				c[--count] = comm[i];
			}
		}
		return c;
	}

	@Override
	public Commodity[] showByDel() {
		int count = 0;
		for (int i = 0; i < index; i++) {
			if (comm[i].getState().equals("�¼�")) {
				count++;
			}
		}
		if (0 == count) {
			return null;
		}
		Commodity[] c = new Commodity[count];
		for (int i = 0; i < index; i++) {
			if (comm[i].getState().equals("�¼�")) {
				c[--count] = comm[i];
			}
		}
		return c;
	}

	@Override
	public Commodity[] sortByAmend(Commodity[] c) {
		
		Commodity a;
		for (int j = 0; j < c.length - 1; j++) {
			for (int i = 0; i < c.length - 1; i++) {
				if (c[i].getAmount() < c[i + 1].getAmount()) {
					a = c[i];
					c[i] = c[i + 1];
					c[i + 1] = a;
				}

			} 
		}
		return c;
	}

}
