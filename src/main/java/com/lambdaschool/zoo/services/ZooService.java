package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Zoo;

import java.util.ArrayList;

/**
 * The Service that works with User Model.
 * <p>
 * Note: Emails are added through the add user process
 * Roles are added through the add user process
 * No way to delete an assigned role
 */
public interface ZooService
{

    ArrayList<Zoo> findAllZoos();

    Zoo findZooById(long zooid);
}