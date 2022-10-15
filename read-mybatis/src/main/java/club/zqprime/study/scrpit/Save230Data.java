package club.zqprime.study.scrpit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
@Slf4j
public class Save230Data {
    @SneakyThrows
    public static void main(String[] args) {
        String ip = "10.1.11.230",user="admin",password="admin",baseFilePath="D:\\服务器\\sql\\bak\\";
        ExecSqlTool2 tool2 = new ExecSqlTool2(ip,"3306",user,password);
        String sqlScript = "";
        tool2.execMysqldump(Test230Databases.getDatabases(),sqlScript,"保存文件",null);


        List<String> databases = Test230Databases.getDatabases();
        CountDownLatch downLatch = new CountDownLatch(databases.size());
        log.info(String.valueOf(databases.size()));
        for (String database : databases) {
            new Thread(()->{
                List<String> list = new ArrayList<>();
                list.add("cmd");
                String sql  = "C: & cd C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin & mysqldump.exe" +
                        " -h "+ip +" -u"+user +" -p"+password+" "+database +" > "+baseFilePath+database+".sql";
                System.out.println(sql);
                list.add("/c");
                list.add(sql);
                final ProcessBuilder builder = new ProcessBuilder(list);
                try {
                    Process process = builder.start();
                    Common.readProcessOutput(process.getInputStream(), System.out);
                    int state = process.exitValue();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                log.info("保存"+database+"完成");
                downLatch.countDown();
            }).start();
        }
        downLatch.await();
        log.info("全部同步完成");
    }

    private static List<String> getDatabases(){
        List<String> strs = Arrays.asList(
                "apijson",
                "association",
                "base-test",
                "blog",
                "bytebase",
                "bytebasedemo",
                "cloudsample",
                "cool",
                "cpt",
                "cr_center",
                "cr_tenant",
                "cr_tenant_bak",
                "crs_default_tenant",
                "crs_qingcheng",
                "crs_tenant",
                "crs_test",
                "cylb",
                "diancan",
                "dist",
                "dist_prod",
                "door",
                "ds",
                "dsdgsd",
                "flyway",
                "fpc_202109020001",
                "fpc_bz_nanjiang_4z",
                "fpc_centre_201116",
                "fpc_comm",
                "fpc_kindergarten",
                "fpc_on_site",
                "fpc_school",
                "gen",
                "general_questionnaire",
                "gms_chengqing",
                "gms_dujiangyan",
                "gms_group",
                "gms_qingcheng",
                "gms_tenant",
                "graduate_interview",
                "house_bind",
                "jeecg",
                "jeecgdb",
                "jimureport",
                "kindergarten",
                "linjiashop",
                "litemall",
                "longquanyi",
                "mall-test",
                "mall_center",
                "mall_default2_tenant",
                "mall_default_group",
                "mall_default_tenant",
                "mall_dujiangyan",
                "mall_gexiancun",
                "mall_qingcheng",
                "mall_shenlong",
                "mall_tenant",
                "mall_test",
                "mall_wunvzhou",
                "mall_xinbang",
                "mc_center",
                "mc_demo",
                "meetingsign",
                "member_huaying",
                "member_tenant",
                "mes",
                "mq",
                "ndy",
                "person_mall",
                "questionnaire",
                "rsczjps",
                "rx",
                "saga",
                "scdxwyz",
                "seat_select",
                "seata",
                "sec",
                "taigu",
                "test",
                "tiaozhanbei",
                "tiaozhanbei_syn",
                "toubiao",
                "tran_center",
                "upms_center",
                "upms_default2_tenant",
                "upms_default_group",
                "upms_default_tenant",
                "upms_dujiangyan",
                "upms_gexiancun",
                "upms_qingcheng",
                "upms_shenlong",
                "upms_tenant",
                "upms_testsyncgroup",
                "upms_wj",
                "upms_wunvzhou",
                "upms_xinbang",
                "wsz",
                "wyz",
                "xxl_job",
                "zzb"
        );
        return new ArrayList<>(strs);
    }
}
