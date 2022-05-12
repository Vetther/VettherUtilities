package dev.vetther.itembuilder.utils;
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2022 Crypto Morin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ReflectionUtils {

    public static final String VERSION;

    static {

        String found = null;
        for (Package pack : Package.getPackages()) {
            String name = pack.getName();

            if (name.startsWith("org.bukkit.craftbukkit.v")) {
                found = pack.getName().split("\\.")[3];

                try {
                    Class.forName("org.bukkit.craftbukkit." + found + ".entity.CraftPlayer");
                    break;
                } catch (ClassNotFoundException e) {
                    found = null;
                }
            }
        }
        if (found == null) throw new IllegalArgumentException("Failed to parse server version. Could not find any package starting with name: 'org.bukkit.craftbukkit.v'");
        VERSION = found;
    }

    public static final int VER = Integer.parseInt(VERSION.substring(1).split("_")[1]);
    public static final String CRAFTBUKKIT = "org.bukkit.craftbukkit." + VERSION + '.';

    private ReflectionUtils() {}

    public static boolean supports(int version) {return VER >= version;}

    @Nullable
    public static Class<?> getCraftClass(@Nonnull String name) {
        try {
            return Class.forName(CRAFTBUKKIT + name);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}