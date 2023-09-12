package ent;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author sy
 * @since 2023-09-12
 */
@Getter
@Setter
@TableName("myBusiness.user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField("id")
    private Integer id;
    @TableField("name")
    private Integer name;
}
