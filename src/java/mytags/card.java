/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Duy.Tran
 */
public class card extends SimpleTagSupport {

    private String name;
    private double price;
    private double discount;
    private String image;
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            double discountedPrice = price - (price * discount / 100);
            out.print("<div class='group w-80 rounded-lg overflow-hidden shadow-lg bg-white m-4 relative hover:shadow-xl transition duration-300 ease-in-out transform hover:-translate-y-1 hover:scale-105'>");
            out.print("<div class='w-full h-80 overflow-hidden'>");
            out.print("<img class='object-cover w-full h-full' src='." + image + "' alt='" + name + "'>");
            out.print("</div>");
            out.print("<div class='px-6 py-4'>");
            out.print("<div class='font-bold text-sm mb-2'>");
            out.print(name);
            out.print("</div>");
            out.print("<div class='flex justify-between items-center'>");
            out.print("<div>");
            if (discount != 0) {
                out.print("<span class='text-gray-600 text-sm line-through mr-2'>");
                out.print(price);
                out.print(" VND</span>");
                out.print("<span class='text-green-600 text-sm font-semibold'>");
                out.print(discountedPrice);
                out.print(" VND</span>");
                out.print("<span class='text-red-600 text-sm ml-2'>");
                out.print(discount);
                out.print("% OFF</span>");
            } else {
                out.print("<span class='text-green-600 text-sm font-semibold'>");
                out.print(price);
                out.print(" VND</span>");
            }
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

  

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
