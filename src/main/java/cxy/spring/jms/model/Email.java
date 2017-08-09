package cxy.spring.jms.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/9 18:48 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Email implements Serializable{

    private static final long serialVersionUID = -8958953279211559214L;
    private String receiver;
    private String title;
    private String content;

}
