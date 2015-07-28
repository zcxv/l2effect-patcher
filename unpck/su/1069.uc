class 1069 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect12
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.su_empower_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect13
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_sleep_ta'
		bOnMultiTarget=True
	End Object
	Desc="슬리프" //Sleep
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect12',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect13',SpecificStage=0)
}