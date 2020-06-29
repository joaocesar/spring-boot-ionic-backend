package com.nelioalves.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

    private static final String EMPTY = "";
    private static final String ENCODE = "UTF-8";

    public static String decodeParam(String str) {
        try {
            return URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            return EMPTY;
        }
    }

    public static List<Integer> decodeIntList(String str) {
        return Arrays.asList(str.split(","))
                .stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
