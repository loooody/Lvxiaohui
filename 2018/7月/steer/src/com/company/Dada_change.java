package com.company;

import java.io.IOException;
import java.text.ParseException;

public abstract class Dada_change {
    public abstract void data_add(String name) throws IOException, ParseException;

    public abstract void data_delete(String name) throws IOException;

    public abstract void data_query(String ID) throws IOException;

    public abstract void print(String str);
}
