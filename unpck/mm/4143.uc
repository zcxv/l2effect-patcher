class 4143 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect0
		AttachOn=AM_LA
		SpawnDelay=0.100000
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_LA
		SpawnDelay=0.200000
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_flame_strike_ra'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect23
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="보물상자 폭발" //Treasure Chest explosion
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect0',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect23',SpecificStage=0)
}