/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 *
 * @author hinsenchan
 */
//director for application controller
public interface SecuritySimControllerDirector {
    public SecuritySimController build(SecuritySimControllerBuilder builder);
}
