package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is purposefully left empty. It is for successful
 * responses from the API that contain no body data.
 *
 * @author Matthew Bell
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Empty {
}
