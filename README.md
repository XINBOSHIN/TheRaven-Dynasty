Добро пожаловать в репозиторий Raven Dynasty!

Raven Dynasty [Minecraft](https://minecraft.net/) является сюжетно-магической модификацией. Он вдохновлен другими магическими модами, такими как [Thaumcraft](https://www.curseforge.com/minecraft/mc-mods/thaumcraft ) или [Магия крови](https://www.curseforge.com/minecraft/mc-mods/blood-magic ). 

Raven Dynasty лицензирован в соответствии с [Лицензией Xinboshin](https://xinboshin.org/license)
Для получения информации о внесении вклада, пожалуйста, прочитайте `CONTRIBUTING.md `.

## Информация о Maven

Артефакты Maven находятся [здесь](https://maven.blamejared.com/vazkii/botania/Botania /), каждая папка представляет собой версию.

Примечание: Начиная с 1.16, промежуточные (не выпускаемые) сборки Maven больше не сохраняются.
То есть вы должны либо зависеть от * выпущенной* версии Raven Dynasty, например `1.16.2-407`, либо специально выбрать передовую
сборку следующей версии. Например, `1..16.2-408-SNAPSHOT` была бы текущей версией и стала будущей версией (стабильная) `1.16.2-408`. 

Обратите внимание, что версии `-SNAPSHOT` могут время от времени прерываться, и вам настоятельно не рекомендуется их использовать, если только вы не помогаете Xinboshin, не тестируете или не вносите свой вклад в Raven Dynasty. Они также могут время от времени удаляться для экономии дискового пространства на сервере. Не * полагайтесь * на версии `-SNAPSHOT` для чего-либо важного!

В Forge добавьте следующее в свой `build.gradle`
```gradle
repositories {
    maven { url 'https://maven.blamejared.com' }
}

dependencies {
    // 1.14+
    compileOnly fg.deobf("vazkii.botania:Botania:[VERSION]:api")
    runtimeOnly fg.deobf("vazkii.botania:Botania:[VERSION]")
}
```
## Устранение неполадок при Mixin

Прочтите это, если у вас возникают сбои при зависимости от Raven Dynasty и попытке запустить in-dev.
Raven Dynasty использует миксины для реализации различных функций.
Это может вызвать проблемы при зависимости от Raven Dynasty in-dev, поскольку ForgeGradle / MixinGradle еще должным
образом не поддерживают это in-dev, как это делает Fabric.
В качестве обходного пути отключите refmaps, определив `mixin.env.disableRefMap`
Аргумент JVM равен `true`.


