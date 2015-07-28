class 1045 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.wh_heal_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_bless_the_body_ta'
		bOnMultiTarget=True
	End Object
	Desc="블레스 더 바디" //Bless The Body
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
}