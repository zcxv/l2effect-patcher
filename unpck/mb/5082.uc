class 5082 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect58
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-0.850000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.s_u804_c_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect59
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u804_a_ta'
		bOnMultiTarget=True
	End Object
	Desc="NPC스피닝 슬래셔 트릭" //Spinning Slasher NPC trick
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect58',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect59',SpecificStage=0)
}