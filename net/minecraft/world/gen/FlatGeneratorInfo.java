/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 */
package net.minecraft.world.gen;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.FlatLayerInfo;

public class FlatGeneratorInfo {
    private final List<FlatLayerInfo> flatLayers = Lists.newArrayList();
    private final Map<String, Map<String, String>> worldFeatures = Maps.newHashMap();
    private int biomeToUse;

    public int getBiome() {
        return this.biomeToUse;
    }

    public void setBiome(int p_82647_1_) {
        this.biomeToUse = p_82647_1_;
    }

    public Map<String, Map<String, String>> getWorldFeatures() {
        return this.worldFeatures;
    }

    public List<FlatLayerInfo> getFlatLayers() {
        return this.flatLayers;
    }

    public void func_82645_d() {
        int i = 0;
        for (FlatLayerInfo flatlayerinfo : this.flatLayers) {
            flatlayerinfo.setMinY(i);
            i += flatlayerinfo.getLayerCount();
        }
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(3);
        stringbuilder.append(";");
        for (int i = 0; i < this.flatLayers.size(); ++i) {
            if (i > 0) {
                stringbuilder.append(",");
            }
            stringbuilder.append(this.flatLayers.get(i).toString());
        }
        stringbuilder.append(";");
        stringbuilder.append(this.biomeToUse);
        if (!this.worldFeatures.isEmpty()) {
            stringbuilder.append(";");
            int k = 0;
            for (Map.Entry<String, Map<String, String>> entry : this.worldFeatures.entrySet()) {
                if (k++ > 0) {
                    stringbuilder.append(",");
                }
                stringbuilder.append(entry.getKey().toLowerCase());
                Map<String, String> map = entry.getValue();
                if (map.isEmpty()) continue;
                stringbuilder.append("(");
                int j = 0;
                for (Map.Entry<String, String> entry1 : map.entrySet()) {
                    if (j++ > 0) {
                        stringbuilder.append(" ");
                    }
                    stringbuilder.append(entry1.getKey());
                    stringbuilder.append("=");
                    stringbuilder.append(entry1.getValue());
                }
                stringbuilder.append(")");
            }
        } else {
            stringbuilder.append(";");
        }
        return stringbuilder.toString();
    }

    private static FlatLayerInfo func_180715_a(int p_180715_0_, String p_180715_1_, int p_180715_2_) {
        Block block;
        int j;
        int i;
        block15: {
            String[] astring = p_180715_0_ >= 3 ? p_180715_1_.split("\\*", 2) : p_180715_1_.split("x", 2);
            i = 1;
            j = 0;
            if (astring.length == 2) {
                try {
                    i = Integer.parseInt(astring[0]);
                    if (p_180715_2_ + i >= 256) {
                        i = 256 - p_180715_2_;
                    }
                    if (i < 0) {
                        i = 0;
                    }
                }
                catch (Throwable var8) {
                    return null;
                }
            }
            block = null;
            try {
                String s = astring[astring.length - 1];
                if (p_180715_0_ < 3) {
                    astring = s.split(":", 2);
                    if (astring.length > 1) {
                        j = Integer.parseInt(astring[1]);
                    }
                    block = Block.getBlockById(Integer.parseInt(astring[0]));
                    break block15;
                }
                astring = s.split(":", 3);
                Block block2 = block = astring.length > 1 ? Block.getBlockFromName(String.valueOf(astring[0]) + ":" + astring[1]) : null;
                if (block != null) {
                    j = astring.length > 2 ? Integer.parseInt(astring[2]) : 0;
                } else {
                    block = Block.getBlockFromName(astring[0]);
                    if (block != null) {
                        int n = j = astring.length > 1 ? Integer.parseInt(astring[1]) : 0;
                    }
                }
                if (block != null) break block15;
                return null;
            }
            catch (Throwable var9) {
                return null;
            }
        }
        if (block == Blocks.air) {
            j = 0;
        }
        if (j < 0 || j > 15) {
            j = 0;
        }
        FlatLayerInfo flatlayerinfo = new FlatLayerInfo(p_180715_0_, i, block, j);
        flatlayerinfo.setMinY(p_180715_2_);
        return flatlayerinfo;
    }

    private static List<FlatLayerInfo> func_180716_a(int p_180716_0_, String p_180716_1_) {
        if (p_180716_1_ != null && p_180716_1_.length() >= 1) {
            ArrayList list = Lists.newArrayList();
            String[] astring = p_180716_1_.split(",");
            int i = 0;
            String[] arrstring = astring;
            int n = astring.length;
            for (int j = 0; j < n; ++j) {
                String s = arrstring[j];
                FlatLayerInfo flatlayerinfo = FlatGeneratorInfo.func_180715_a(p_180716_0_, s, i);
                if (flatlayerinfo == null) {
                    return null;
                }
                list.add(flatlayerinfo);
                i += flatlayerinfo.getLayerCount();
            }
            return list;
        }
        return null;
    }

    public static FlatGeneratorInfo createFlatGeneratorFromString(String p_82651_0_) {
        int i;
        if (p_82651_0_ == null) {
            return FlatGeneratorInfo.getDefaultFlatGenerator();
        }
        String[] astring = p_82651_0_.split(";", -1);
        int n = i = astring.length == 1 ? 0 : MathHelper.parseIntWithDefault(astring[0], 0);
        if (i >= 0 && i <= 3) {
            List<FlatLayerInfo> list;
            FlatGeneratorInfo flatgeneratorinfo = new FlatGeneratorInfo();
            int j = astring.length == 1 ? 0 : 1;
            if ((list = FlatGeneratorInfo.func_180716_a(i, astring[j++])) != null && !list.isEmpty()) {
                flatgeneratorinfo.getFlatLayers().addAll(list);
                flatgeneratorinfo.func_82645_d();
                int k = BiomeGenBase.plains.biomeID;
                if (i > 0 && astring.length > j) {
                    k = MathHelper.parseIntWithDefault(astring[j++], k);
                }
                flatgeneratorinfo.setBiome(k);
                if (i > 0 && astring.length > j) {
                    String[] astring1;
                    String[] arrstring = astring1 = astring[j++].toLowerCase().split(",");
                    int n2 = astring1.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        String s = arrstring[i2];
                        String[] astring2 = s.split("\\(", 2);
                        HashMap map = Maps.newHashMap();
                        if (astring2[0].length() <= 0) continue;
                        flatgeneratorinfo.getWorldFeatures().put(astring2[0], map);
                        if (astring2.length <= 1 || !astring2[1].endsWith(")") || astring2[1].length() <= 1) continue;
                        String[] astring3 = astring2[1].substring(0, astring2[1].length() - 1).split(" ");
                        for (int l = 0; l < astring3.length; ++l) {
                            String[] astring4 = astring3[l].split("=", 2);
                            if (astring4.length != 2) continue;
                            map.put(astring4[0], astring4[1]);
                        }
                    }
                } else {
                    flatgeneratorinfo.getWorldFeatures().put("village", Maps.newHashMap());
                }
                return flatgeneratorinfo;
            }
            return FlatGeneratorInfo.getDefaultFlatGenerator();
        }
        return FlatGeneratorInfo.getDefaultFlatGenerator();
    }

    public static FlatGeneratorInfo getDefaultFlatGenerator() {
        FlatGeneratorInfo flatgeneratorinfo = new FlatGeneratorInfo();
        flatgeneratorinfo.setBiome(BiomeGenBase.plains.biomeID);
        flatgeneratorinfo.getFlatLayers().add(new FlatLayerInfo(1, Blocks.bedrock));
        flatgeneratorinfo.getFlatLayers().add(new FlatLayerInfo(2, Blocks.dirt));
        flatgeneratorinfo.getFlatLayers().add(new FlatLayerInfo(1, Blocks.grass));
        flatgeneratorinfo.func_82645_d();
        flatgeneratorinfo.getWorldFeatures().put("village", Maps.newHashMap());
        return flatgeneratorinfo;
    }
}
