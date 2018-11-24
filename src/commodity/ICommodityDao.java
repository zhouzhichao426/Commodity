package commodity;

public interface ICommodityDao {
	boolean save(Commodity c);
	Commodity del(String name,int n);
	boolean amend(String id);	//�޸�
	Commodity[] showAll();		//����ȫ��
	Commodity showById(String id);
	Commodity[] showByName(String name);
	Commodity[] showByprice(int a,int b);	//���ݼ۸�����
	Commodity[] showByDel();
	Commodity[] sortByAmend(Commodity[] c);
	
	
	
	
	
	
}
