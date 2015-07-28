class 5097 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect46
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.at_shock_blast_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect47
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.rm_self_blaster_ra'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect78
		AttachOn=AM_LA
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect79
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="안타라스자폭소형" //JI small Antharas
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect46',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect47',SpecificStage=0)
	CastingActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect78',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect79',SpecificStage=0)
}