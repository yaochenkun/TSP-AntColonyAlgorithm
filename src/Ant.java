import java.util.Random;

//����
public class Ant 
{
	int[] passed;//�Ѿ����ĳ����б����ɱ�
	float passedLength=0.0f;//���γ���
	int curCity;//���ϵ�ǰ���ڳ���
	int curIndex;//��ǰ�����±�
	
	//��ʼ����������
	void init()
	{
		initPassed();
		passedLength=0.0f;
		curIndex=0;
		initBeginCity();
	}
	
	//��ʼ�����ɱ�
	void initPassed()
	{
		passed=new int[Constant.CITY_NUM+1];
		for(int i=0;i<passed.length;i++)
			passed[i]=Integer.MIN_VALUE;
	}
	
	//��ʼ���������ڳ���
	void initBeginCity()
	{
		Random rand=new Random();
		int beginCity=rand.nextInt(Constant.CITY_NUM);
		reachNextCity(beginCity);
	}
	
	//������һ������
	void reachNextCity(int nextCity)
	{
		//�ۼ����ξ���
		passedLength += Constant.routes[curCity][nextCity].distance;
		
		//ǰ��
		curCity=nextCity;
		passed[curIndex++]=nextCity+1;
	}
	
	//�жϳ���nCity�Ƿ��ڽ��ɱ���
	boolean isPassedCity(int nCity)
	{
		for(int i=0;passed[i] != Integer.MIN_VALUE;i++)
		{
			if(passed[i] == nCity) //���ڵĳ���
				return true;
		}
		return false;
	}
}
