package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.Views.AnimalCount;
import com.lambdaschool.zoo.models.Animal;

import java.util.ArrayList;

/**
 * The service that works with the Role Model.
 * <p>
 * Note: no method update Role name
 */
public interface AnimalService
{
    ArrayList<AnimalCount> animalCount();
}