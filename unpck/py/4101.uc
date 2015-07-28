class 4101 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.at_fatal_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_fatal_strike_ta'
		bOnMultiTarget=True
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		SpawnDelay=0.100000
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_fatal_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="npc 스피닝 슬래셔" //Spinning Slasher npc
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
}