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
		String s2 = "活动项目ID(PIID)	活动项目名称（选出）	营业区编码(固定表中区--地区区号)	业务名称（政企+尊享保底）	产品ID（产品号码+年月日+时间戳）	产品号码（手机号）	支付对象ID（接口取供应商ID）	结算开始时间(稽核后给)	结算结束时间（稽核后给）	结算持续时间（承诺保底月份sharePeriod）	终端结算价（导入的终端供货价wholesalePrice）	承诺保底金额（导入的保底值guaranteValue）	封顶金额 终端结算价*1.3（稽核计算得）	销售品ID（稽核获取）	销售品名称（稽核获取）	有效状态 	保留字段1	保留字段1	保留字段1	保留字段1	批次	项目还是清单（0、1）	历史分成钱 当月为1	业务id	支付对象名称";
		
//		System.out.println(unformateColumn("herh"));
		System.out.println(toStringArray("String", "title1", s2));// 不加字段转化的转成数组字符串
		System.out.println("inf_repay_product".indexOf("inf_repay_product"));// 不加字段转化的转成数组字符串
//		System.out.println(toStringTransArray("String[]", "keys1", s1));// 加字段转化的转成数组字符串
	}
	
	/**
	 * 转成数组, 不自动转_后一位为大写
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
	 * 转成数组, 自动转_后一位为大写
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
	 * 去除字段的_, 比如 wxw_user_name -> wxwUserName
	 * @param culumn 传入要转换的字符串
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
	 * 加上字段的_, 比如 wxwUserName -> wxw_user_name
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
