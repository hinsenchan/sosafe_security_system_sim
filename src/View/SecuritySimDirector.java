/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

/**
 *
 * @author hinsenchan
 */
//abstract director for security sim
public interface SecuritySimDirector {
    public SecuritySim build(SecuritySimBuilder securitySimBuilder);
}
