package com.asteroid.pncode.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Relations between users and role.
 *
 * @author YuSai
 */
@Data
@Entity
@Table(name = "t_user_role")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * User id.
     */
    private int uid;

    /**
     * Role id.
     */
    private int rid;
}
