package cn.itcast.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		// 1.���������ļ�
		ClientGlobal.init("D://git//fastDFSdemo//fastDFSdemo//src//main//resources//fdfs_client.conf");
		// 2.����һ�������߿ͻ���
		TrackerClient client=new TrackerClient();
		// 3.���ӹ����߷����
		TrackerServer trackerServer = client.getConnection();
		//4. �����洢�����
		StorageServer storageServer=null;
		//5. ��ȡ�洢�������Ŀͻ��˶���
		StorageClient storageClient=new StorageClient(trackerServer, storageServer);
		//6.�ϴ��ļ�
		String[] strings = storageClient.upload_file("D://ceshi//����.PNG", "PNG", null);
		//7.��ʾ�ϴ���� file_id
		//�ļ�·��
		/**
		 * ���ؽ��
		 * group1
		 * M00/00/00/wKgZhV0BreCAfulpAAB9UeIga0g379.PNG
		 * 
		 * �ļ�·��
		 * ip/group1/M00/00/00/wKgZhV0BreCAfulpAAB9UeIga0g379.PNG
		 */
		for(String str:strings){
			System.out.println(str);
		}		
		
	}

}
