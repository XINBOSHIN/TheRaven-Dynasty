package com.xinboshin.theravendynasty.item;


@ObjectHolder("theravendynasty")
@Mod.EventBusSubscriber// Автоматическая регистрация статичных обработчиков событий
public class ItemsRegistry {
    @ObjectHolder("bookofdarkness")
    public static final Item KEY = null;


    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        // Также вместо `register` можно использовать `registerAll`, чтобы прописать все предметы разом
        e.getRegistry().register(new ItemKey());
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {

    }
}