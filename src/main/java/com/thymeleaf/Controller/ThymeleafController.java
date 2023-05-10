package com.thymeleaf.Controller;

import com.thymeleaf.model.entity.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@Controller
public class ThymeleafController {
    private static List<Info> infos = new ArrayList<>();
    @GetMapping
    public String thymeLeaf() {
            return "thymeleaf";
    }

    @GetMapping("standardExpressionSyntax")
    public String standarExpressionSyntax(Model model){
        Info info = new Info("tuoi:","12");
        model.addAttribute("file",info);
        return "standardExpressionSyntax";
    }
    @PostMapping("create")
    public String createForm(@ModelAttribute Info info,Model model){
        if (!info.getKey().contains("Lớp")){
            model.addAttribute("error","Key phải chứa chữ: Lớp");
           return "createForm";
        }
        if (!info.getValue().contains("123")) {
            model.addAttribute("mess", "Trong value phải có số 123");
            return "createForm";
        }
        infos.add(info);
        model.addAttribute("infos",infos);
        return "settingAttributeValues";
    }
    @GetMapping("settingAttributeValues")
    public String getForm(Model model){
        model.addAttribute("infos",infos);
        return "settingAttributeValues";
    }

    @GetMapping("/infos/new")
    public String showCreateForm(Model model) {
        model.addAttribute("info", new Info());
//        model.addAttribute("error", "");
        return "createForm";
    }

    @GetMapping("interration")
    public String interation(Model model){
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("fullname", "Dinh Zuan Loc"));
        profile.add(new Info("fullname", "Dinh Zuan Loc"));
        profile.add(new Info("fullname", "Dinh Zuan Loc"));
        model.addAttribute("lodaProfile", profile);
        return "interation";
    }
    @GetMapping("conditionalEvaluation")
    public String conditionalEvaluation(Model model){
        Info info = new Info("Nguyên Quán","Hà Nội");
        model.addAttribute("file",info);
        return "conditionalEvaluation";
    }
    @GetMapping("localVariables")
    public String localVariables(Model model){
        Info info = new Info("ten","le trung kiennnnn");
        model.addAttribute("Info",info);
        return "localVariables";
    }

    @GetMapping("commentsAndBlocks")
    public String commentsAndBlocks(Model model){
        Info info = new Info("tuoi:","12");
        model.addAttribute("file",info);
        return "commentsAndBlocks";
    }




    @GetMapping("inlining")
    public String profile(Model model){
        model.addAttribute("h1","center");
        model.addAttribute("h2","red");
        model.addAttribute("js","day la nhung html");
        return "inliningg";
    }

}
