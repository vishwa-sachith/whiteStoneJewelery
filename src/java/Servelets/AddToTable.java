/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Classes.AddToTableObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author ASUS
 */
public class AddToTable extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("remove")!= null) {
            remove(req, resp);
        } else {
            add(req, resp);
        }
        
        
        
    }
    
    
    
    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        
        HashMap<String, AddToTableObject> tbh = (HashMap<String, AddToTableObject>) req.getSession().getAttribute("tbhmap");
        
            JSONArray ar = new JSONArray();

        for (Map.Entry me : tbh.entrySet()) {

            JSONObject ob = new JSONObject();
            AddToTableObject gg = (AddToTableObject) me.getValue();

            ob.put("stoneid", gg.getStoneid());
            ob.put("details", gg.getDetails());
            ob.put("weight", gg.getWeight());
            ob.put("weightmesu", gg.getWeightmesu());
            ob.put("puritydeta", gg.getPuritydeta());
            ob.put("count", gg.getCount());
            ob.put("id", "" + gg.getStoneid() + gg.getWeight() + gg.getWeightmesuid() + gg.getWeightmesu() + gg.getPurityid() + gg.getPuritydeta());
            
            ar.add(ob);

        }

        resp.getWriter().write(ar.toJSONString());
    
    }
    
    
    
    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        if ("all".equals(req.getParameter("remove"))) {
            req.getSession().setAttribute("tbhmap", null);
        } else {
            HashMap<String, AddToTableObject> tbh = (HashMap<String, AddToTableObject>) req.getSession().getAttribute("tbhmap");
            tbh.remove(""+req.getParameter("remove"));
            req.getSession().setAttribute("tbhmap", tbh);
            search(req, resp);
        }
    
    }
    
    
    
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        
        String details = req.getParameter("details");
        String stoneid = req.getParameter("stoneid");
        String weight = req.getParameter("weight");
        String weightmesuid = req.getParameter("weightmesuid");
        String weightmesu = req.getParameter("weightmesu");
        String purityid = req.getParameter("purityid");
        String puritydeta = req.getParameter("puritydeta");
        String count = req.getParameter("count");

        AddToTableObject ss = new AddToTableObject();
        ss.setStoneid(stoneid);
        ss.setDetails(details);
        ss.setWeight(weight);
        ss.setWeightmesuid(weightmesuid);
        ss.setWeightmesu(weightmesu);
        ss.setPurityid(purityid);
        ss.setPuritydeta(puritydeta);
        ss.setCount(count);

        HashMap<String, AddToTableObject> tbh = new <String, AddToTableObject> HashMap();

        if (req.getSession().getAttribute("tbhmap") != null) {
            tbh = (HashMap) req.getSession().getAttribute("tbhmap");
        }

        if (tbh.get("" + stoneid + weight + weightmesuid + weightmesu + purityid + puritydeta) != null) {
            AddToTableObject si = tbh.get("" + stoneid + weight + weightmesuid + weightmesu + purityid + puritydeta);

            int i1 = Integer.parseInt(si.getCount());
            int i2 = Integer.parseInt(count);

            si.setCount(Integer.toString(i1 + i2));

            tbh.put("" + stoneid + weight + weightmesuid + weightmesu + purityid + puritydeta, si);
        } else {
            tbh.put("" + stoneid + weight + weightmesuid + weightmesu + purityid + puritydeta, ss);
        }

        req.getSession().setAttribute("tbhmap", tbh);

        
        search(req, resp);
    
    }
    

}
