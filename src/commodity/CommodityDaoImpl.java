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
				System.out.println("请输入你要修改的内容选项");
				System.out.println("1.名字");
				System.out.println("2.商品单价");
				System.out.println("3.商品数量");
				System.out.println("4.商品状态");
				int a = s.nextInt();
				if (1 == a) {
					System.out.println("输入你要修改的名字");
					comm[i].setName(s.nextLine());
					System.out.println("修改成功");
				} else if (2 == a) {
					System.out.println("请输入你要修改的单价");
					comm[i].setPrice(s.nextDouble());
					System.out.println("修改成功");
				} else if (3 == a) {
					System.out.println("请输入你要修改的数量");
					comm[i].setAmount(s.nextInt());
					System.out.println("修改成功");
				} else if (4 == a) {
					System.out.println("请输入你要修改的商品状态");
					comm[i].setState(s.nextLine());
					System.out.println("修改成功");
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
			if (comm[i].getState().equals("下架")) {
				count++;
			}
		}
		if (0 == count) {
			return null;
		}
		Commodity[] c = new Commodity[count];
		for (int i = 0; i < index; i++) {
			if (comm[i].getState().equals("下架")) {
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
