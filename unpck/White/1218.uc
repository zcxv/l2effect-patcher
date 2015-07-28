class 1218 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect12
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_sec_heal_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect13
		AttachOn=AM_LA
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_greater_heal_ta'
		bOnMultiTarget=True
	End Object
	Desc="그레이터 배틀 힐" //Greater Battle Hill
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect12',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect13',SpecificStage=0)
}