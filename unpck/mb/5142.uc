class 5142 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect73
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.bl_berserker_spirit_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect75
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.rm_self_blaster_ra'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect77
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="몬스터자폭" //Monster Suicide
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect73',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect75',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect77',SpecificStage=0)
}