package com.xinboshin.theravendynasty;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.xinboshin.theravendynasty.handlers.Config;
import com.xinboshin.theravendynasty.handlers.GenericEventHandler;
import com.xinboshin.theravendynasty.network.packets.Packet;
import com.xinboshin.theravendynasty.proxy.CommonProxy;

@Mod(modid = TheRavenDynasty.MODID, version = TheRavenDynasty.VERSION, name = TheRavenDynasty.NAME)
public class TheRavenDynasty {
    public static final String MODID = "theravendynaty";
    public static final String NAME = "The Raven Dynasty";
    public static final String VERSION = "1.0.3";

    public static SimpleNetworkWrapper packetHandler;

    @SidedProxy(clientSide = "com.xinboshin.theravendynasty.proxy.ClientProxy", serverSide = "com.xinboshin.theravendynasty.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final Logger logger = LogManager.getLogger("TheRavenDynasty");
    public static final int howCoolAmI = Integer.MAX_VALUE;

    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        // NO-OP
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.load(event);

        packetHandler = NetworkRegistry.INSTANCE.newSimpleChannel("TheRavenDynastyChannel");
        packetHandler.registerMessage(Packet.Handler.class, Packet.class, 1, Side.CLIENT);

        MinecraftForge.EVENT_BUS.register(new GenericEventHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
    }

    public static CreativeTabs tabTheRavenDynasty = new CreativeTabs("tabTheRavenDynasty") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };
}
