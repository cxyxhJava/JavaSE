package db;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 20:51 2019-11-15
 * @ Description：
 * @ Modified By：
 */

public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {
        String[] args2 = {"db.Member"};
        if (args2.length<1){
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }

        for (String className : args2) {
            Class<?> cl = Class.forName(className);
            //获取 dbTable注解类
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable==null){
                System.out.println("No DB table in class"+className);
                continue;
            }
            String tableName = dbTable.name();
            //如果db.Member无表名 用类名
            if (tableName.length()<1){
                tableName = cl.getName().toUpperCase();
                System.out.println("cl.name:"+cl.getName());
                System.out.println("tableName:"+tableName);
            }

            List<String> columnDefs = new ArrayList<String>();
            //获取类的所有元素
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                //从元素中获取注解类型
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length<1){
                    continue;
                }
                //如果是SQLInteger类型 获取
                if (anns[0] instanceof SQLInteger){
                    SQLInteger sqlInteger = (SQLInteger) anns[0];
                    //如果无元素名称 使用类名
                    columnName = sqlInteger.name().length()<1?field.getName().toUpperCase():sqlInteger.name();
                    columnDefs.add(columnName+" INT"+getConstraints(sqlInteger.constraints()));
                }
                //其他类型 依次填写
                if (anns[0] instanceof SQLString){
                    SQLString sqlString = (SQLString) anns[0];
                    //如果无元素名称 使用类名
                    columnName = sqlString.name().length()<1?field.getName().toUpperCase():sqlString.name();
                    columnDefs.add(columnName+" VARCHAR("+sqlString.value()+")"+getConstraints(sqlString.constraints()));
                }
                //拼接创建sql
                StringBuilder createCommand = new StringBuilder(
                        "CREATE TABLE "+tableName+"("
                );
                for (String columnDef : columnDefs) {
                    createCommand.append("\n"+columnDef+",");
                }
                //去除最后的一个逗号
                String tableCreate = createCommand.substring(0,createCommand.length()-1);
                System.out.println("创建表的sql为: \n"+tableCreate);

            }


        }
    }

    public static String getConstraints(Constraints constraints){
        String constraintsStr = "";
        if (!constraints.allowNull()){
            constraintsStr+=" NOT NULL";
        }
        if (constraints.primaryKey()){
            constraintsStr+=" PRIMARY KEY";
        }
        if (constraints.unique()){
            constraintsStr+=" UNIQUE";
        }

        return constraintsStr;
    }

}


