class 78 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect8
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.mo_war_cry_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect13
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.mo_war_cry_ta'
		bOnMultiTarget=True
	End Object
	Desc="워 크라이" //War Cry
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect8',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect13',SpecificStage=0)
}