package cc.wdcy.web.controller.mobile;

import cc.wdcy.domain.dto.UserJsonDto;
import cc.wdcy.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

import static cc.wdcy.web.WebUtils.writeJson;

/**
 * @author Shengzhao Li
 */
@Controller
@RequestMapping("/m/")
public class MobileController {

    @Autowired
    private UserService userService;


    @RequestMapping("dashboard.htm")
    public String dashboard() {
        return "mobile/dashboard";
    }

    @RequestMapping("user_info")
    public void userInfo(HttpServletResponse response) throws Exception {
        final UserJsonDto jsonDto = userService.loadCurrentUserJsonDto();
        writeJson(response, JSONObject.fromObject(jsonDto));
    }

}