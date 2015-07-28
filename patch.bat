@echo off

REM 
REM После патчинга создается бекап. Пропатченый файл не меняет своего имени.
REM 

REM файл для изменения. может быть любой .u файл. должен находится в импортах
SET file=skill.usk

REM обьект который менять
SET object=at.SkillAction_LocateEffect7

REM тип того что менять
SET field=EffectClass

REM на что поменять
SET effect=LineageEffect.su_sleep_ta

java -cp ./efpatcher.jar;./io.jar ru.rage.efpatcher.Starter -object %object% -field %field% -effect %effect% -file %file%
pause