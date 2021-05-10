package com.example.demo.controllers;

import com.example.demo.entities.Cat;
import com.example.demo.entities.Pair;
import com.example.demo.entities.User;
import com.example.demo.repositories.CatRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Controller
public class CatController {
    @Autowired
    private final CatRepository repository;

    @Autowired
    private final UserRepository userRepository;
    List<Cat> listCat;
    List<Pair> pairList = new ArrayList<>();

    private String[] arrayCats= new String[] {
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Alfie.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Angel.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Bella.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Blacky.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Charlie.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Chloe.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Coco.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Daisy.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Eve.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Felix.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Ginger.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Jasper.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Kitty.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Lala.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Lisa.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Lucy.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Max.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Milo.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Minka.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Misty.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Molly.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Moritz.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Muschi.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Oliver.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Oscar.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Pallina.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Poppy.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Puss.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Sacha.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Sam.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Shadow.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Smokey.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Smudge.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Sooty.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Susi.jpg",
            "https://raw.githubusercontent.com/zemlyansckygrigorij/mimimimetr/master/src/main/resources/pictures/Tiger.jpg"
    };
    @Autowired
    public CatController(CatRepository repository, UserRepository userRepository) throws Exception {

        this.repository = repository;
        this.userRepository = userRepository;

        int i =0;
        listCat = new ArrayList<>();
        for(String string:arrayCats){
            Cat cat = new Cat();
            i++;
            cat.setId(i);
            cat.setRating(0);
            cat.setPath(string);

            int start =  string.lastIndexOf("/");
            int finish =  string.lastIndexOf(".");
            cat.setName(string.substring(start+1,finish));
            repository.save(cat);
        }
        setPairList();
    }

    @GetMapping("/pairs/{id}")
    public  String  findPairById(@PathVariable int id,Model model)throws Exception {
        User currentUser = userRepository.getUserByUsername(SecurityContextHolder.getContext()
                .getAuthentication().getName());
        if(id>pairList.size()-1) throw new Exception();
        Pair pair = pairList.get(id);

        model.addAttribute("firstCat", pair.getFirstCat());
        model.addAttribute("secondCat", pair.getSecondCat());
        model.addAttribute("voted", currentUser.isVoted());

        if(currentUser.isVoted())return "hello";

        if(id<pairList.size()-1){
            model.addAttribute("id", id+1);
        }else{
            model.addAttribute("id", 1);
        }
        return "index";
    }

    @GetMapping("/pairs/result")
    public  String  resultCats(Model model) {

        User currentUser = userRepository.getUserByUsername(SecurityContextHolder.getContext()
                .getAuthentication().getName());
        currentUser.setVoted(true);
        userRepository.save(currentUser);

        List<Cat> listCats = repository.findAll();
        List<Cat> sendCats = listCats.stream()
                .sorted(comparing(Cat::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
        model.addAttribute("cats", sendCats);

        return "result";
    }

    @RequestMapping("/logout")
    public String getLogOutPage() {
        return "redirect:/login";
    }
    @RequestMapping("/")
    public String getPage() {
        return "redirect:/pairs/1";
    }

    @RequestMapping(value="/pairs/{id}", method=RequestMethod.POST)
    public String greetingSubmit(@RequestParam(value = "cid", required = false) Integer cid,@PathVariable int id,@ModelAttribute Cat cat, Model model) {

        if(repository.findById((long)cid).isPresent()){
            Cat catById = repository.findById((long)cid).get();
            catById.setRating(catById.getRating()+1);
            repository.save(catById);
        }

        if(id<pairList.size()-1){
            id++;
            return "redirect:/pairs/"+id;
        }else{
            return "redirect:/pairs/result";
        }
    }

    private int getRandomInt(){
        Random random = new Random();
        return  random.nextInt(5);
    }

    public void setPairList() throws Exception {
        listCat  = repository.findAll();
        if(pairList.size()>0)pairList.removeAll(pairList);
        while(listCat.size()>1){
            Pair pair = new Pair();
            int random = getRandomInt();
            if(random<listCat.size()){
                pair.setFirstCat( listCat.remove(random));
                pair.setSecondCat( listCat.remove(0));
            }else{
                pair.setFirstCat( listCat.remove(1));
                pair.setSecondCat( listCat.remove(0));
            }
            pairList.add(pair);
        }
    }
}
