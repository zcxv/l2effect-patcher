class 5204 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect28
		AttachOn=AM_LA
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.ch_gourd_death_long'
	End Object
	Desc="초거대돼지합체" //Super huge pig copolymer
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect28',SpecificStage=0)
}