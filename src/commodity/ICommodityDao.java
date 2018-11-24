package commodity;

public interface ICommodityDao {
	boolean save(Commodity c);
	Commodity del(String name,int n);
	boolean amend(String id);	//修改
	Commodity[] showAll();		//查找全部
	Commodity showById(String id);
	Commodity[] showByName(String name);
	Commodity[] showByprice(int a,int b);	//根据价格区间
	Commodity[] showByDel();
	Commodity[] sortByAmend(Commodity[] c);
	
	
	
	
	
	
}
