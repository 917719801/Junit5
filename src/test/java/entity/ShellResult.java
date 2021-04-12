package entity;

import lombok.Data;

/*
shell脚本的执行结果
 */
@Data
public class ShellResult {
    private String caseName;
    private  boolean result;

}
