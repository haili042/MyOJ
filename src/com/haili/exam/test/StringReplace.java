/**
 * 
 */
package com.haili.exam.test;


/**
 * @author Administrator
 *
 */
public class StringReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  s1 = "project_id	project_name	area_id	bss_name	repay_id	repay_nbr	provider_id	start_dt	end_dt	last_months	td_price	bd_charge	upper_charge	offer_spec_id	offer_spec	status_cd	col_1	col_2	col_3	col_4	batch_id	dt_flag	div_pprice	bss_id	provider";
		String s2 = "���ĿID(PIID)	���Ŀ���ƣ�ѡ����	Ӫҵ������(�̶�������--��������)	ҵ�����ƣ�����+�����ף�	��ƷID����Ʒ����+������+ʱ�����	��Ʒ���루�ֻ��ţ�	֧������ID���ӿ�ȡ��Ӧ��ID��	���㿪ʼʱ��(���˺��)	�������ʱ�䣨���˺����	�������ʱ�䣨��ŵ�����·�sharePeriod��	�ն˽���ۣ�������ն˹�����wholesalePrice��	��ŵ���׽�����ı���ֵguaranteValue��	�ⶥ��� �ն˽����*1.3�����˼���ã�	����ƷID�����˻�ȡ��	����Ʒ���ƣ����˻�ȡ��	��Ч״̬ 	�����ֶ�1	�����ֶ�1	�����ֶ�1	�����ֶ�1	����	��Ŀ�����嵥��0��1��	��ʷ�ֳ�Ǯ ����Ϊ1	ҵ��id	֧����������";
		
//		System.out.println(unformateColumn("herh"));
		System.out.println(toStringArray("String", "title1", s2));// �����ֶ�ת����ת�������ַ���
		System.out.println("inf_repay_product".indexOf("inf_repay_product"));// �����ֶ�ת����ת�������ַ���
//		System.out.println(toStringTransArray("String[]", "keys1", s1));// ���ֶ�ת����ת�������ַ���
	}
	
	/**
	 * ת������, ���Զ�ת_��һλΪ��д
	 * */
	public static String toStringArray(String type, String param, String res){
		String result =  type + " " + param + " = {\"" + res.replace("\t", "\",\"") + "\"};";
		
//		for (int i = 0; i < result.length(); i++) {
//			if(result.length()){
//				
//			}
//			result.substring(70, 80);
//		}
//		result.indexOf(",");
		return result;
	}
	
	/**
	 * ת������, �Զ�ת_��һλΪ��д
	 * */
	public static String toStringTransArray(String type, String param, String res){
		String [] array = res.split("\t");
		for (int i = 0; i < array.length; i++) {
			array[i] = formateColumn(array[i]);
		}
		String result =  type + " " + param + " = {";
		for (int i = 0; i < array.length; i++) {
			result += "\"" + array[i] + "\",";
		}
		result += "};";
		return result;
	}
	
	public static String findMinLength(){
		return "";
	}
	
	public static String toJsExpression(String title, String res, String expression){
		
		return "";
	}
	
	public static String remove_(){
		return "";
	}
	
	/**
	 * ȥ���ֶε�_, ���� wxw_user_name -> wxwUserName
	 * @param culumn ����Ҫת�����ַ���
	 * 
	 * */
	public static String formateColumn(String culumn) {
		StringBuffer sb = new StringBuffer(culumn);
		for (int j = 0; j < sb.length(); j++) {
			if(sb.charAt(j) == '_'){
				if(j == sb.length()-1){
					culumn = culumn.substring(0, j);
					break;
				}
				String upper = sb.substring(j+1, j+2).toUpperCase();
				sb.replace(j, j + 2,upper);
				culumn = sb.toString();
			};
		}
		return culumn;
	}
	
	/**
	 * �����ֶε�_, ���� wxwUserName -> wxw_user_name
	 * 
	 * */
	public static String unformateColumn(String culumn) {
		StringBuffer sb = new StringBuffer(culumn);
		for (int j = 0; j < sb.length(); j++) {
			if(sb.charAt(j) >= 'A' && sb.charAt(j) <= 'Z'){
				String lowwer = "_" + sb.substring(j, j+1).toLowerCase();
				sb.replace(j, j + 1,lowwer);
				culumn = sb.toString();
			};
		}
		return culumn;
	}
}
